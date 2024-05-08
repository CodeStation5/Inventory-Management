package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import com.example.demo.repositories.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {
    @Autowired
    private ApplicationContext appView;

    private PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;
    private final InhousePartRepository inhousePartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository, InhousePartRepository inhousePartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
        this.inhousePartRepository=inhousePartRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        // variables to keep track of parts/products count
        long numParts;
        long numProducts;
        numParts = partRepository.count();
        numProducts = productRepository.count();
        PartService partService = appView.getBean(PartServiceImpl.class);

        // Make more parts only if there are no parts already made
        if (numParts == 0) {
            InhousePart ram = new InhousePart();
            ram.setId(1000);
            ram.setName("RAM");
            ram.setPrice(150.00);
            ram.setInv(20);
            ram.setInvLow(5);
            ram.setInvHigh(50);

            InhousePart cpu = new InhousePart();
            cpu.setId(2000);
            cpu.setName("CPU");
            cpu.setPrice(200.00);
            cpu.setInv(20);
            cpu.setInvLow(5);
            cpu.setInvHigh(50);

            InhousePart drive = new InhousePart();
            drive.setId(3000);
            drive.setName("Hard Drive");
            drive.setPrice(100.00);
            drive.setInv(20);
            drive.setInvLow(5);
            drive.setInvHigh(50);

            InhousePart pcCase = new InhousePart();
            pcCase.setId(4000);
            pcCase.setName("Case");
            pcCase.setPrice(120.00);
            pcCase.setInv(20);
            pcCase.setInvLow(5);
            pcCase.setInvHigh(50);

            InhousePart gpu = new InhousePart();
            gpu.setId(5000);
            gpu.setName("GPU");
            gpu.setPrice(1500.00);
            gpu.setInv(20);
            gpu.setInvLow(5);
            gpu.setInvHigh(50);

            // Save all created parts
            inhousePartRepository.save(ram);
            inhousePartRepository.save(cpu);
            inhousePartRepository.save(drive);
            inhousePartRepository.save(pcCase);
            inhousePartRepository.save(gpu);
        }
        else {
            System.out.println("Parts already registered into system");
        }

        // Make more products only if there are no products already made
        if (numProducts == 0) {
            // Input is name/price/inventory
            Product serverPC = new Product("Server PC",100.00, 100);
            Product lowPC = new Product("Low End PC",100.00, 50);
            Product midPC = new Product("Mid Range PC",100.00, 30);
            Product gamingPC = new Product("Gaming PC",100.00, 20);
            Product minePC = new Product("Mining PC",100.00, 10);

            // Save all created products
            productRepository.save(serverPC);
            productRepository.save(lowPC);
            productRepository.save(midPC);
            productRepository.save(gamingPC);
            productRepository.save(minePC);
        }
        // If products are already made, then there's no reason to initialize them
        else {
            System.out.println("Products already registered into system");
        }

        // Print out the number of products and parts
        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
