package co.edu.unbosque.servletjsptutorial.services;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

import co.edu.unbosque.servletjsptutorial.dtos.User;

public class UserService {

	public List<User> getUsers() throws IOException {

		List<User> users;

		try (InputStream is = UserService.class.getClassLoader().getResourceAsStream("users.csv")) {

			HeaderColumnNameMappingStrategy<User> strategy = new HeaderColumnNameMappingStrategy<>();
			strategy.setType(User.class);

			try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {

				CsvToBean<User> csvToBean = new CsvToBeanBuilder<User>(br).withType(User.class)
						.withMappingStrategy(strategy).withIgnoreLeadingWhiteSpace(true).build();

				users = csvToBean.parse();
			}
		}

		return users;
	}

	public void createUser(String username, String password, String role, String path) throws IOException {
		String newLine = "\n" + username + "," + password + "," + role;
		FileOutputStream os = new FileOutputStream(path + "WEB-INF/classes/" + "users.csv", true);
		os.write(newLine.getBytes());
		os.close();
	}
}
