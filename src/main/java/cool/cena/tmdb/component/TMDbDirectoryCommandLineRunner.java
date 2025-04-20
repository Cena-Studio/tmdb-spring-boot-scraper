package cool.cena.tmdb.component;

import java.io.File;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import cool.cena.tmdb.helper.TMDbConstraint;

@Component
public class TMDbDirectoryCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        File imgFileDir = new File(TMDbConstraint.IMG_FILE_DIR);
        if (!imgFileDir.exists()){
            imgFileDir.mkdirs();
        }
    }


}
