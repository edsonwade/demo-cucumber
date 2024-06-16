package code.with.vanilson.cucumber.product;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

/**
 * ProductService
 *
 * @author vamuhong
 * @version 1.0
 * @since 2024-06-16
 */
@Service
@Slf4j
@Transactional
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public List<ProductDTO> getProducts() {
        List<Product> products = productRepository.findAll();
        log.info("Found {} products", products.size());
        return productMapper.mapToProductDTOList(products);
    }

    public Optional<ProductDTO> getProduct(int id) {
        return Optional.ofNullable(productRepository.findById(id)
                .map(productMapper::mapToProductDto)
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found")));
    }

    public ProductDTO createProduct(Product product) {
        try {
            var savedProduct = productRepository.save(product);
            log.info("Saved product {}", savedProduct);
            return productMapper.mapToProductDto(savedProduct);
        } catch (Exception e) {
            log.error("Error creating product: {}", e.getMessage(), e);
            throw e; // Re-throw or handle accordingly
        }
    }

    public ProductDTO updateProducts(int id, Product product) {
        try {
            var existingProductOptional = productRepository.findById(id);
            if (existingProductOptional.isPresent()) {
                var existingProduct = existingProductOptional.get();
                existingProduct.setName(product.getName());
                existingProduct.setQuantity(product.getQuantity());
                existingProduct.setPrice(product.getPrice());
                var updatedProduct = productRepository.save(existingProduct);
                log.info("Updated product with id {} and name {}", id, product.getName());
                return productMapper.mapToProductDto(updatedProduct);
            } else {
                log.error("Product with id {} not found", id);
                throw new ProductNotFoundException("Product with id " + id + " not found");
            }
        } catch (Exception e) {
            log.error("Error updating product: {}", e.getMessage(), e);
            throw e; // Re-throw or handle accordingly
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteProductById(int id) {
        var productDeleted = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found"));
        productRepository.delete(productDeleted);
    }
}

