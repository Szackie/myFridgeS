package fridge.szackie.fridge;

import fridge.szackie.product.Product;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "fridges")

public class Fridge {
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private int fridge_id;
    private String name;
    @OneToMany
    @JoinColumn(name = "fridge_id")
    @Column(name="productlist")
    private List<Product> productList;


    public Fridge() {
    }

    public Fridge(int fridge_id, String name, List<Product> productList) {
        this.fridge_id = fridge_id;
        this.name = name;
        this.productList = productList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setFridge_id(int id) {
        this.fridge_id = id;
    }

    public int getFridge_id() {
        return fridge_id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}


