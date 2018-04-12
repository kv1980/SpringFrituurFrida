package be.vdab.frituurfrida.repositories;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import be.vdab.frituurfrida.entities.Saus;
import be.vdab.frituurfrida.exceptions.SausRepositoryException;

@Component
class CSVSausRepository implements SausRepository {
	private static final Path PAD = Paths.get("/data/sauzen.csv");
	private static final Logger LOGGER = LoggerFactory.getLogger(CSVSausRepository.class);

	@Override
	public List<Saus> findAll() {
		List<Saus> sauzenlijst = new ArrayList<>();
		try (BufferedReader reader = Files.newBufferedReader(PAD)) {  
			for (String regel; (regel = reader.readLine()) != null;) {
				regel.replaceAll("\\s+","");
				String[] onderdelen = regel.split(",");
				if (onderdelen.length < 2) {
					String fout = PAD+": "+regel+" bevat minder dan 2 onderdelen";
					LOGGER.error(fout);
					throw new SausRepositoryException(fout);
				}
				try {
					long nummer = Long.parseLong(onderdelen[0]);
					String naam = onderdelen[1];
					List<String> ingredienten = new ArrayList<>();
					for (int i = 2; i<onderdelen.length;i++) {
						ingredienten.add(onderdelen[i]);
					}
					sauzenlijst.add(new Saus(nummer,naam,ingredienten));
				} catch (NumberFormatException ex) {
					String fout = PAD+": "+regel+" bevat foutieve id van het type long";
					LOGGER.error(fout,ex);
					throw new SausRepositoryException(fout);
				}
			}
		} catch (IOException ex) {
			String fout = PAD+": dit bestand kon niet worden ingelezen.";
			LOGGER.error(fout,ex);
			throw new SausRepositoryException(fout);
		} 
		return sauzenlijst;
	}
}
