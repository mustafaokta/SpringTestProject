package com.proje.model.productqueries;

public class ProductQueries {
public static final String saveProductQuery="INSERT INTO product(productId, productName, unitPrice, avalible, addDate, updateDate, categoryId, brandId) VALUES (?,?,?,?,?,?,?,?)";
public static final String updateProductQuery="UPDATE product SET productName=?, unitPrice=?, avalible=?, updateDate=? categoryId=? brandId=? WHERE productId=?";

public static final String deleteUser_ProductQuery="DELETE FROM user_product WHERE productId=?";
public static final String deleteProductQuery="DELETE FROM product WHERE productId=?";
public static final String findProductById="SELECT * FROM product WHERE productId=?";
public static final String findProductsQueries="SELECT * FROM product";

}
