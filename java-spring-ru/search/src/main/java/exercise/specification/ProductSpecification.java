package exercise.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import exercise.dto.ProductParamsDTO;
import exercise.model.Product;

// BEGIN
@Component // Для возможности автоматической инъекции
public class ProductSpecification {
    // Генерация спецификации на основе параметров внутри DTO
    // Для удобства каждый фильтр вынесен в свой метод
    public Specification<Product> build(ProductParamsDTO params) {
        return withCategoryId(params.getCategoryId())
                .and(withPriceGt(params.getPriceGt())
                .and(withPriceLt(params.getPriceLt())
                .and(withRatingGt(params.getPriceGt())
                .and(withTitleCont(params.getTitleCont())))));
    }

    private Specification<Product> withCategoryId(Long productId) {
        return (root, query, cb) -> productId == null ? cb.conjunction() : cb.equal(root.get("product").get("id"), productId);
    }

    private Specification<Product> withPriceGt(Long productId) {
        return (root, query, cb) -> productId == null ? cb.conjunction() : cb.equal(root.get("product").get("id"), productId);
    }

    private Specification<Product> withPriceLt(Long productId) {
        return (root, query, cb) -> productId == null ? cb.conjunction() : cb.equal(root.get("product").get("id"), productId);
    }

    private Specification<Product> withRatingGt(Long productId) {
        return (root, query, cb) -> productId == null ? cb.conjunction() : cb.equal(root.get("product").get("id"), productId);
    }

    private Specification<Product> withTitleCont(String productId) {
        return (root, query, cb) -> productId == null ? cb.conjunction() : cb.equal(root.get("product").get("id"), productId);
    }
}
// END
