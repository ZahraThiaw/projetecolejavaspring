package sn.odc.oumar.springproject.Datas.Seeders;


import org.springframework.beans.factory.annotation.Autowired;
import sn.odc.oumar.springproject.Datas.Entity.Module;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sn.odc.oumar.springproject.Datas.Repository.Interfaces.ModuleRepository;


public class ModuleSeeder implements CommandLineRunner {
    private final ModuleRepository moduleRepository;


    public ModuleSeeder(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    @Override
    public void run(String... args) {
        // Ajouter des modules par défaut
        Module module1 = new Module();
        module1.setNom("Module 1");
        module1.setDescription("Description du module 1");
        module1.setDureeAcquisition(30);
        //moduleRepository.save(module1);


        // Ajoutez d'autres modules si nécessaire

    }
}
