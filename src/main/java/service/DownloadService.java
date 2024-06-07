package service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;



@Service
public class DownloadService {
	
	
	private final ExecutorService executorservice = Executors.newFixedThreadPool(10);
	private final HttpClient httpclient = HttpClient.newBuilder().build();
	
	
	
	public void downloadsongs(List<String> songurls , String downloadDir)throws InterruptedException
	{
		for(String url : songurls)
		{
			executorservice.submit(()->{
				try
				{
					HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
					HttpResponse<byte[]> response = httpclient.send(request, HttpResponse.BodyHandlers.ofByteArray());
					java.nio.file.Path path = Paths.get(downloadDir,extractFilename(url));
					Files.write(path, response.body());
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
			});
			}
		executorservice.shutdown();
		executorservice.awaitTermination(1, TimeUnit.HOURS);
		}
	private String extractFilename(String url)
	{
		return url.substring(url.lastIndexOf('/')+1);
	}

}
