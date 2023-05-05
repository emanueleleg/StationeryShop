package ibm.cic.stage.shopBackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ibm.cic.stage.shopBackend.Dao;
import ibm.cic.stage.shopBackend.entity.Brand;
import ibm.cic.stage.shopBackend.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService {
	
	@Autowired
	private Dao dao;

	@Override
	public String getBrands() {
		ObjectMapper mapper = new ObjectMapper(); 
		List<Brand> brands = dao.getBrands();
		String result = "";
		
		try {
			result = mapper.writeValueAsString(brands);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		return result;
	}


}
