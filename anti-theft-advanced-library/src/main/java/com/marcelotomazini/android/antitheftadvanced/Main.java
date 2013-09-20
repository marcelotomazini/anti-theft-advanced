package com.marcelotomazini.android.antitheftadvanced;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;

public class Main {

	private static final String APPLICATION_NAME = "MarceloTomazini-AntiTheftAdvanced/1.0";
	private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport(); //GoogleNetHttpTransport.newTrustedTransport();
	private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
	private static final File DATA_STORE_DIR = new File(System.getProperty("user.home"), ".credentials/mapsengine.json");
	private static FileDataStoreFactory dataStoreFactory;

	private static Credential authorize() throws Exception {
		GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(Main.class.getResourceAsStream("/client_secrets.json")));
		
		dataStoreFactory = new FileDataStoreFactory(DATA_STORE_DIR);

		GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
				HTTP_TRANSPORT,
				JSON_FACTORY,
				clientSecrets,
				Collections.singleton("https://www.googleapis.com/auth/mapsengine.readonly"))
				.setDataStoreFactory(dataStoreFactory).build();

		return new AuthorizationCodeInstalledApp(flow, new LocalServerReceiver()).authorize("user");
	}

	public static void main(String[] args) {
		try {
			Credential credential = authorize();

			// Make a request to list all maps in a particular project.
			URL url = new URL("https://www.googleapis.com/mapsengine/v1/maps");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setDoOutput(true);
			connection.setRequestProperty("Authorization", "Bearer " + credential.getAccessToken());
			connection.connect();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (Throwable t) {
			t.printStackTrace();
		}

	}
}