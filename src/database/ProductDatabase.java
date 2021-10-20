package database;

import enums.Availability_status;
import models.Category;
import models.Product;
import models.ProductConfig;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDatabase extends DatabaseConnector {

    public ProductDatabase() {
        super();
    }

    //checking is there productId or not
    public boolean isThereThisProduct(int productId) {
        String query = "SELECT `product`.`product_id` FROM `online_store`.`product` WHERE product_id='%S';\n";
        query = String.format(query,productId);

        try {
            Statement statement = getStatement();
            ResultSet set       = statement.executeQuery(query);

            if (set.next())
                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    //get all products
    public List<Product> getAllProducts()  {
        List<Product> products = new ArrayList<>();

        String query_product = "SELECT * FROM online_store.product;";

        try {
            Statement statement = getStatement();
            ResultSet set       = statement.executeQuery(query_product);

            while (set.next()) {
                int                 productID    = set.getInt("product_id");
                String              productName  = set.getString("product_name");
                double              productPrice = set.getDouble("price");
                int                 productCount = set.getInt("count");
                Availability_status status       = set.getString("availablility_status").equals(Availability_status.AVAILABLE.toString()) ?
                        Availability_status.AVAILABLE:Availability_status.NOT_AVAILABLE;


                //get product config for this product from database
                String query_productConfig = String.format("SELECT `config`.`config_id`,`config`.`mark`,`config`.`value` FROM `online_store`.`config` WHERE product_id='%S';",productID);
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
                        " WHERE product_id='%S';",productID);
                ResultSet resultSet_category = getStatement().executeQuery(query_category);
                Category category = null;
                if (resultSet_category.next()) {
                    int    catID       = resultSet_category.getInt("category_id");
                    String title       = resultSet_category.getString("title");
                    String description = resultSet_category.getString("description");
                    String subtitle    = resultSet_category.getString("subtitle");
                    category = new Category(catID,title,description,subtitle);
                }


                products.add(new Product(productName,productPrice,productCount,status,category,productConfigs));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

}
