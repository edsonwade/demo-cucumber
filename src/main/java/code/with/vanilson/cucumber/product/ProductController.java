package code.with.vanilson.cucumber.product;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

/**
 * ProductController
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-06-16
 */
@RestController
@RequestMapping(path = "/products")
@Slf4j
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Retrieves a list of all products.
     *
     * @return a ResponseEntity containing a list of ProductDTOs
     */
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> products = productService.getProducts();
        log.info("getAllProducts called");
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param id the ID of the product to retrieve
     * @return a ResponseEntity containing the ProductDTO
     */
    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProductDTO>> getProductById(@PathVariable int id) {
        log.info("getProductById called");
        return ResponseEntity.ok().body((productService.getProduct(id)));
    }

    /**
     * Creates a new product.
     *
     * @param product the product to create
     * @return a ResponseEntity containing the created ProductDTO
     */
    @PostMapping("/create-product")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody @Valid Product product) {
        ProductDTO createdProduct = productService.createProduct(product);
        log.info("createProduct called");
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    /**
     * Updates an existing product.
     *
     * @param id      the ID of the product to update
     * @param product the new product details
     * @return a ResponseEntity containing the updated ProductDTO
     */
    @PutMapping("/update-product/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable int id, @RequestBody Product product) {
        try {
            ProductDTO updatedProduct = productService.updateProducts(id, product);
            log.info("updateProduct called");
            return ResponseEntity.ok(updatedProduct);
        } catch (ProductNotFoundException e) {
            log.error("updateProduct called failed with id {} ", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    /**
     * Deletes a product by its ID.
     *
     * @param id the ID of the product to delete
     * @return a ResponseEntity with no content
     */
    @DeleteMapping("/delete-product/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable int id) {
        try {
            productService.deleteProductById(id);
            log.info("deleteProductById called {}", id);
            return ResponseEntity.noContent().build();
        } catch (ProductNotFoundException e) {
            log.error("deleteProductById called failed with id {} ", id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}