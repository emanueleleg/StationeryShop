package ibm.cic.stage.shopBackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ibm.cic.stage.shopBackend.Dao;
import ibm.cic.stage.shopBackend.entity.Category;
import ibm.cic.stage.shopBackend.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private Dao dao;

	@Override
	public String getCategories() {
		ObjectMapper mapper = new ObjectMapper(); 
		List<Category> categories = dao.getCategories();
		String result = "";
		
		try {
			result = mapper.writeValueAsString(categories);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
