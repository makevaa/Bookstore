package hh.sof3.bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import hh.sof3.bookstore.domain.Category;
import hh.sof3.bookstore.domain.CategoryRepository;

@ExtendWith(SpringExtension.class)  // JUnit5 eli Jupiter
@DataJpaTest
public class CategoryRepositoryTests {

    @Autowired
    private CategoryRepository repository;

    @Autowired
    TestEntityManager entityManager;

    // Test finding category by name
    @Test 
    public void findCategoryByName() {
        Category category = new Category("history");
        repository.save(category);
        List<Category> categories = repository.findByName("history");
        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getName()).isEqualTo("history");
    }

    // Test creating a new category
    @Test
    public void createCategory() {
        Category category = new Category(null);
        repository.save(category);
        assertThat(category.getCategoryid()).isNotNull();
    }

    // Test deleting a category
    @Test
    public void deleteCategory() {
        Category category = new Category(null);
        entityManager.persist(category);
        repository.delete(category);
	    assertThat(entityManager.find(Category.class, category.getCategoryid())).isNull();
    }
}