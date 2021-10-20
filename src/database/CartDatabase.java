package database;

import entry.Login;
import enums.Availability_status;
import models.*;

import javax.swing.plaf.nimbus.State;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CartDatabase extends DatabaseConnector{

    public CartDatabase() {
        super();
    }

    //adding new order to customer cart
    public void addNewOrderToCart(int productId,int count) {
        String query = "INSERT INTO `online_store`.`cart`" +
                "(`count`," +
                "`product_id`," +
                "`customer_id`)" +
                "VALUES" +
                "('%s','%s','%s');";
        query = String.format(query,count,productId, Login.customerID);

        try {
            Statement statement = getStatement();
            statement.executeUpdate(query);

            //low off count of product in shop
            getStatement().executeUpdate(String.format("UPDATE `online_store`.`product`" +
                    "SET`count` = count-'%s'  WHERE `product_id` = '%s';",count,productId));

        } catch (SQLException e) {
            System.out.println("error while sending query to database \n"+e.toString());
        }

        closeConnection();

    }

    //deleting order from cart
    public void deleteOrderFromCart(int cartID) {
        String query = "DELETE FROM `online_store`.`cart` WHERE cart_id='%s';";
        query = String.format(query,cartID);

        try {
            Statement statement = getStatement();
            statement.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //is there product with this count in database
    public boolean isThereInDatabase(int productId,int count) {
        String query = "SELECT count FROM online_store.product WHERE product_id='%S' ;";
        query = String.format(query,productId);

        try {
            Statement statement = getStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                boolean result = resultSet.getInt("count") >= count ? true : false;
                closeConnection();
                return result;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }


    public List<Cart> getProductInCart() { //todo
        List<Cart> carts  = null;

        String query_product = "SELECT `cart`.`cart_id`, `cart`.`count`, `cart`.`product_id` FROM `online_store`.`cart`;";

        try {
            Statement statement = getStatement();
            ResultSet set       = statement.executeQuery(query_product);

            while (set.next()) {

                int cartId    = set.getInt("cart_id");
                int count     = set.getInt("count");
                int productId = set.getInt("product_id");

                String    query_productInfo = "SELECT `product`.`product_id`,`product`.`product_name`,`product`.`price`,`product`.`count`,`product`.`availablility_status`\n" +
                        "FROM `online_store`.`product`WHERE product_id='%s';";
                query_productInfo           = String.format(query_productInfo,productId);
                ResultSet resultSet         = getStatement().executeQuery(query_productInfo);

                resultSet.next();
                String              productName  = set.getString("product_name");
                double              productPrice = set.getDouble("price");
                int                 productCount = set.getInt("count");
                Availability_status status       = set.getString("availablility_status").equals(Availability_status.AVAILABLE.toString()) ?
                        Availability_status.AVAILABLE:Availability_status.NOT_AVAILABLE;


                //get product config for this product from database
                String query_productConfig = String.format("SELECT `config`.`config_id`,`config`.`mark`,`config`.`value` FROM `online_store`.`config` WHERE product_id='%S';",productId);
                ResultSet resultSet_config = getStatement().executeQuery(query_productConfig);
                List<ProductConfig> productConfigs = new ArrayList<>();
                while (resultSet_config.next()) {
                    int   configId = resultSet_config.getInt("config_id");
                    String mark    = resultSet_config.getString("mark");
                    String value   = resultSet_config.getString("value");
                    productConfigs.add(new ProductConfig(configId,mark,value));
                }

                //get product category for this product from database
                String query_category = String.format("SELECT `category`.`category_id`,`category`.`title`,`category`.`description`,`category`.`subtitle` FROM `online_store`.`category`" +
                        " WHERE product_id='%S';",productId);
                ResultSet resultSet_category = getStatement().executeQuery(query_category);
                Category category = null;
                if (resultSet_category.next()) {
                    int    catID       = resultSet_category.getInt("category_id");
                    String title       = resultSet_category.getString("title");
                    String description = resultSet_category.getString("description");
                    String subtitle    = resultSet_category.getString("subtitle");
                    category = new Category(catID,title,description,subtitle);
                }


                carts.add(new Cart(cartId,productCount,productId,Login.customerID,new Product(productName,productPrice,productCount,status,category,productConfigs)));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return carts;
    }

}
