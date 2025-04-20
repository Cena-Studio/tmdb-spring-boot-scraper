package cool.cena.tmdb.component;

import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import cool.cena.tmdb.helper.TMDbConstraint;

@Component
public class TMDbDirectoryCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        if (!Files.exists(Path.of(TMDbConstraint.imgFileDir))){
            Files.createDirectories(Path.of(TMDbConstraint.imgFileDir));
        }
    }


}
