package ibm.cic.stage.shopBackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ibm.cic.stage.shopBackend.Dao;
import ibm.cic.stage.shopBackend.entity.ProductPreview;
import ibm.cic.stage.shopBackend.service.ProductPreviewService;


@Service
public class ProductPreviewServiceImpl implements ProductPreviewService {
	
	@Autowired
	private Dao dao;

	@Override
	public String getOrderedImagesByProd() {
		ObjectMapper mapper = new ObjectMapper(); 
		List<ProductPreview> categories = dao.getOrderedImagesByProd();
		String result = "";
		
		try {
			result = mapper.writeValueAsString(categories);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
