package com.romano.image_api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/images")
public class ImageController {

	private final ImageRepository imageRepository;
	
	public ImageController(ImageRepository imageRepository) {
		this.imageRepository = imageRepository;
	}
	
	@GetMapping
	public ResponseEntity getAllImages() {
		return ResponseEntity.ok(this.imageRepository.findAll());
	}
	
	@GetMapping("{id}")
	//TODO Ajouter une exception pour quand id inexistant
	public ResponseEntity getOneImage(@PathVariable Long id) {
		return ResponseEntity.ok(this.imageRepository.findById(id));
	}

	@PostMapping
	public ResponseEntity postImage(@RequestBody Image image) throws ParseException {	
        // Get the date string from the image object
        String dateStr = image.getDate();

        // Define date parsers for input and output formats
        SimpleDateFormat inputDateParser = new SimpleDateFormat("yyyy-MM-dd"); // Format for input
        SimpleDateFormat outputDateFormatter = new SimpleDateFormat("dd/MM/yyyy"); // Format for output

        // Parse the date string to a java.util.Date object
        java.util.Date date = inputDateParser.parse(dateStr);

        // Format the date object to the desired output format
        String formattedDate = outputDateFormatter.format(date);

        // Set the formatted date back to the image object
        image.setDate(formattedDate);

        // Save the image object to the repository
        Image savedImage = imageRepository.save(image);

        // Return a response with the saved image object
        return ResponseEntity.status(201).body(savedImage);
		
	}
	
	
	
	
	
}
