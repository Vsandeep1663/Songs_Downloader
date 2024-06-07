package controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import service.DownloadService;

@Controller
public class DownloadController {

	
	@Autowired
	private DownloadService downloadservice;
	
	
	@GetMapping("/")
	public String index()
	{
		return "index";
	}
	
	
	@PostMapping("/download")
	public String download(@RequestParam("urls")String urls , Model model)
	{
		List<String> songurls = Arrays.asList(urls.split("\n"));
		String downloadDir = "downloads";
		
		try {
            downloadservice.downloadsongs(songurls, downloadDir);
            model.addAttribute("message", "Songs downloaded successfully!");
        } catch (InterruptedException e) {
            e.printStackTrace();
            model.addAttribute("message", "Error downloading songs.");
        }
		
		
		return "index";
	}
}
