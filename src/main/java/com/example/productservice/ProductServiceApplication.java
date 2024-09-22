package com.example.productservice;


//import com.productservice.productservice.services.Productservice;
import com.example.productservice.models.Category;
import com.example.productservice.models.Price;
import com.example.productservice.repositories.PriceRepository;
import com.example.productservice.models.Product;
import com.example.productservice.repositories.CategoryRepository;
import com.example.productservice.repositories.ProductRepository;
        import org.springframework.boot.CommandLineRunner;
        import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final PriceRepository priceRepository;

    public ProductServiceApplication(CategoryRepository categoryRepository,
                                     ProductRepository productRepository,
                                     PriceRepository priceRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;
    }

//    private MentorRepository mentorRepository;
//    private StudentRepository studentRepository;
//    private UserRepository userRepository;
//
//    ProductServiceApplication(@Qualifier("tpc_mentorRepository") MentorRepository mentorRepository, StudentRepository studentRepository, UserRepository userRepository){
//        this.mentorRepository = mentorRepository;
//        this.studentRepository = studentRepository;
//        this.userRepository = userRepository;
//    }
//    public static void main(String[] args) {
//        SpringApplication.run(ProductServiceApplication.class, args);
//    }

    @Override
    public void run(String... args) throws Exception {
//        Mentor mentor = new Mentor();
//        mentor.setName("Akshit");
//        mentor.setEmail("Akshit.Gupta@gmail.com");
//        mentor.setAvgRating(4.5);
//
//        mentorRepository.save(mentor);

//        Mentor mentor = new Mentor();
//        mentor.setName("Akshit");
//        mentor.setEmail("Akshit.Gupta@gmail.com");
//        mentor.setAvgRating(4.5);
//        mentorRepository.save(mentor);
//
//        Student student = new Student();
//        student.setName("Akshit");
//        student.setEmail("Akshit@gmail.com");
//        student.setPsp(87);
//        studentRepository.save(student);
//
//        User user = new User();
//        user.setName("abc");
//        user.setEmail("abc@gmail.com");
//        userRepository.save(user);
//        Category category = new Category();
//        category.setName("Apple Devices");
//
//        Category savedCategory = categoryRepository.save(category);

         Optional<Category> optionalCategory = categoryRepository.findById(UUID.fromString());
         if (optionalCategory.isEmpty()){
             throw new Exception("Category was null");
         }
         Category category = optionalCategory.get();

//        Product product = new Product();
//        product.setTitle("Iphone 15 pro");
//        product.setDescription("Best Iphone ever");
//        product.setCategory(savedCategory);
//
//        Product savedProduct = productRepository.save(product);

        // Find all the product with category = Apple device

        List<Product> products = category.getProducts();
        for (Product product : products){
            System.out.println(product.getTitle());
        }

        Price price = new Price();
        price.setCurrency("INR");
        price.setValue(100000);
        Price savedPrice = priceRepository.save(price);


//        category.setName("Apple Devices");

        //get all the users

//        List<User> users = userRepository.findAll();
//        for (User user1 : users) {
//            System.out.println(user1.toString());
        }
    }
//}
