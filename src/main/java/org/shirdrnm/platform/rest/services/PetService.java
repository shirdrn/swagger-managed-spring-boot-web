package org.shirdrnm.platform.rest.services;

import org.shirdrnm.platform.rest.common.AbstractRESTService;
import org.shirdrnm.platform.rest.common.RESTApiResponse;
import org.shirdrnm.platform.rest.common.exceptions.ConflictException;
import org.shirdrnm.platform.rest.common.exceptions.NotFoundException;
import org.shirdrnm.platform.rest.constants.ApiTag;
import org.shirdrnm.platform.rest.test.data.PetData;
import org.shirdrnm.platform.rest.test.models.Category;
import org.shirdrnm.platform.rest.test.models.Pet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class PetService extends AbstractRESTService {
	
    private static PetData data = new PetData();
    
    /**
     * Get a pet from the given <code>petId</code>.
     * @param petId
     * @return
     * @throws Exception
     */
    @ApiOperation(
		tags = {ApiTag.GET_PETS}, 
		notes = "Returns a pet when 0 < ID <= 10.  ID > 10 or non-integers will simulate API error conditions", 
		value = "Find pet by ID", 
		nickname = "getPetById"
    )
    @ApiResponses({
        @ApiResponse(code = RESTApiResponse.OK, message = "Nice!", response = Pet.class),
        @ApiResponse(code = RESTApiResponse.BAD_REQUEST, message = "Invalid ID supplied", response = RESTApiResponse.class),
        @ApiResponse(code = RESTApiResponse.NOT_FOUND, message = "Pet not found", response = RESTApiResponse.class), 
        @ApiResponse(code = RESTApiResponse.SERVICE_UNAVAILABLE, message = "Service unavailable", response = RESTApiResponse.class)
    })
    @RequestMapping(
		value = "/pets/{id}", 
		method = RequestMethod.GET, 
		produces = "application/json"
    )
    public ResponseEntity<Pet> getPetById(
    		@ApiParam(value = "ID of pet that needs to be fetched", allowableValues = "range[1,10]", required = true) 
    		@PathVariable("id") Integer petId
    ) throws Exception {
        Pet pet = data.getPetById(petId);
        if(pet != null) {
            return ResponseEntity.ok().body(pet);
        } else {
            throw new NotFoundException("Pet " + petId + " not found");
        }
    }
    
    /**
     * Add a pet into the pet DB.
     * @param petId
     * @param name
     * @param catId
     * @return
     * @throws Exception
     */
    @ApiOperation(
		tags = {ApiTag.ADD_PETS}, 
		notes = "Add a pet", 
		value = "Add a pet", 
		nickname = "addPet"
    )
    @ApiResponses({
		@ApiResponse(code = RESTApiResponse.OK, message = "Nice!", response = Pet.class),
		@ApiResponse(code = RESTApiResponse.BAD_REQUEST, message = "Invalid ID supplied", response = RESTApiResponse.class),
		@ApiResponse(code = RESTApiResponse.CONFLICT, message = "Pet already exsited", response = RESTApiResponse.class), 
		@ApiResponse(code = RESTApiResponse.SERVICE_UNAVAILABLE, message = "Service unavailable", response = RESTApiResponse.class)
    })
    @RequestMapping(
    		value = "/pets/addPet/{id}/{name}/{catId}", 
    		method = RequestMethod.POST, 
    		produces = "application/json"
    )
    public ResponseEntity<Pet> addPet(
    		@ApiParam(value = "ID of pet that needs to be added", allowableValues = "range[1,infinity]", required = true) 
    		@PathVariable("id") Integer petId,
    		@ApiParam(value = "Name of pet that needs to be added", required = true) 
    		@PathVariable("name") String name,
    		@ApiParam(value = "ID of category this pet belonging to", allowableValues = "range[1,4]", required = true) 
    		@PathVariable("catId") Integer catId
    ) throws Exception {
		Pet pet = new Pet();
		pet.setId(petId);
		pet.setName(name);
		Category cat = new Category();
		cat.setId(catId);
		pet.setCategory(cat);
        if(data.addPet(pet)) {
        	return ResponseEntity.ok().body(pet);
        } else {
        	throw new ConflictException("Pet " + petId + " already exsited");
        }
        
    }
    
}
