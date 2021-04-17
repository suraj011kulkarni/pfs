package com.pfs.erp.config;

import com.pfs.erp.domain.Contents;
import com.pfs.erp.domain.Product;
import com.pfs.erp.domain.ProductContents;

import java.util.HashSet;
import java.util.Set;

public class Bootstrap {

    public static Set<Product> productSet = new HashSet<>();
    public static Set<Contents> contentsSet = new HashSet<>();
    public static Set<ProductContents> productContents = new HashSet<>();

    public static void init(){
        setupProduct();
        setupContent();
        setupProductContent();
        setupBasePrice();
        setupSellPrice();
    }

    public static void setupProduct(){
        Product p1 = new Product(1L,"tandul papd",0.0,0.0,1.0,60.0);
        Product p2 = new Product(2L,"poha papd",0.0,0.0,1.0,60.0);
        Product p3 = new Product(3L,"papd",0.0,0.0,1.0,60.0);
        Product p4 = new Product(4L,"kurudai",0.0,0.0,1.0,100.0);
        Product p5 = new Product(5L,"kharodi",0.0,0.0,1.0,40.0);
        productSet.add(p1);        productSet.add(p2);        productSet.add(p3);
        productSet.add(p4);        productSet.add(p5);
    }

    public  static void setupContent(){

        Contents c1 = new Contents(1L,"tandul",20.0,1.0);
        Contents c2 = new Contents(2L,"poha",20.0,1.0);
        Contents c3 = new Contents(3L,"papad khar",30.0,1.0);
        Contents c4 = new Contents(4L,"udit",80.0,1.0);
        Contents c5 = new Contents(5L,"moong",60.0,1.0);
        Contents c6 = new Contents(6L,"ghavu",30.0,1.0);
        Contents c7 = new Contents(7L,"jwari",20.0,1.0);
        Contents c8 = new Contents(8L,"mire",100.0,1.0);
        contentsSet.add(c1);contentsSet.add(c2);contentsSet.add(c3);contentsSet.add(c4);
        contentsSet.add(c5);contentsSet.add(c6);contentsSet.add(c7);contentsSet.add(c8);

    }

    public static Product getProductById(Long id){
        for(Product p : productSet){
            if(p.getId().equals(id)){
                return p;
            }
        }
        return null;
    }

    public static Product getProductByName(String name){
        for(Product p : productSet){
           if(p.getName().equalsIgnoreCase(name)){
               return p;
           }
        }
        return null;
    }

    public static Contents getContentById(Long id){
        for(Contents c : contentsSet){
            if(c.getId().equals(id)){
                return c;
            }
        }
        return null;
    }

    public static Contents getContentByName(String name){
        for(Contents c : contentsSet){
            if(c.getName().equalsIgnoreCase(name)){
                return c;
            }
        }
        return null;
    }



    public static ProductContents getByProductNameAndContentsName(String productName,String contentsName){
        for(ProductContents pc : productContents){
            if(pc.getProduct().getName().equalsIgnoreCase(productName)
                    && pc.getContents().getName().equalsIgnoreCase(contentsName)){
                return pc;
            }
        }
        return null;
    }

    public static ProductContents getProductContentsById(Long id){
        for(ProductContents pc : productContents){
            if(pc.getId().equals(id)){
                return pc;
            }
        }
        return null;
    }



    public static void setupProductContent(){

        ProductContents pc1 = new ProductContents(1L,getProductByName("tandul papd"),getContentByName("tandul"),1.5);

        ProductContents pc2 = new ProductContents(2L,getProductByName("poha papd"),getContentByName("poha"),2.0);

        ProductContents pc3 = new ProductContents(3L,getProductByName("papd"),getContentByName("udit"),0.5);
        ProductContents pc4 = new ProductContents(4L,getProductByName("papd"),getContentByName("moong"),0.5);
        ProductContents pc5 = new ProductContents(5L,getProductByName("papd"),getContentByName("papad khar"),0.1);
        productContents.add(pc1);
        productContents.add(pc2);
        productContents.add(pc3);
        productContents.add(pc4);
        productContents.add(pc5);
    }


    public static void setupBasePrice(){



        for(ProductContents pc : productContents){

           Product p = pc.getProduct();
           Contents c = pc.getContents();
           Double basePrice = p.getBasePrice() + (c.getPrice()*pc.getWeight());
           p.setBasePrice(basePrice);

        }

    }

    public static void setupSellPrice(){



        for(Product p : productSet){
            p.setSellPrice((((p.getBasePrice()+p.getManufacturingCost())/ 100) * 50) + p.getBasePrice() );
        }

    }



}
