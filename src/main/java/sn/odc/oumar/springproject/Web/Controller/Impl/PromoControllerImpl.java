package sn.odc.oumar.springproject.Web.Controller.Impl;



import io.swagger.v3.oas.annotations.tags.Tag;
import sn.odc.oumar.springproject.Datas.Entity.Promo;
import sn.odc.oumar.springproject.Services.Interfaces.PromoService;
import sn.odc.oumar.springproject.Services.Interfaces.ResponseService;
import sn.odc.oumar.springproject.Web.Controller.BaseControllerImpl;
import sn.odc.oumar.springproject.Web.Controller.Interfaces.PromoControllerInterface;
import sn.odc.oumar.springproject.Web.Dtos.Request.PromotionRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.odc.oumar.springproject.Web.Dtos.Response.BaseResponse;
import sn.odc.oumar.springproject.Web.Dtos.Response.PromoDTO;

@RestController
@RequestMapping("/api/v1/promos")
@Tag(name = "promotions", description = "API pour gérer les promotions")
public class PromoControllerImpl extends BaseControllerImpl<Promo, PromoDTO, Long> implements PromoControllerInterface {


    private final PromoService promoService;
    @Autowired
    protected ResponseService responseService;

    @Autowired
    public PromoControllerImpl(PromoService promoService) {
        super(promoService);
        this.promoService = promoService;
    }


    @PostMapping("/create")
    public ResponseEntity<BaseResponse<Promo>> create(@RequestBody PromotionRequestDTO requestDTO) {
        try {
            // Check if a promotion with the same libelle already exists
            if (promoService.promoExists(requestDTO.getLibelle())) {
                return responseService.notFoundResponse( "libelle already exists");
            }

            Promo promotion = new Promo();
            promotion.setLibelle(requestDTO.getLibelle());
            promotion.setDateDebut(requestDTO.getDateDebut());
            promotion.setDateFin(requestDTO.getDateFin());

            // Save the promotion using the service
            Promo savedPromo = promoService.create(promotion);

            // Return success response
            return   responseService.successResponse(savedPromo, "Entities retrieved successfully");
        } catch (Exception e) {
            // Handle exceptions and return error response
            return  responseService.errorResponse(e.getMessage());
        }
    }
//    @GetMapping("/{id}")
//    public ResponseEntity<ApiResponse<Promo>> getPromotionById(@PathVariable Long id) {
//        Optional<Promo> promo = promoService.findById(id);
//        return promo.map(value -> ResponseEntity.ok(
//                new ApiResponse<>("success", HttpStatus.ACCEPTED, "Promotion found", value)
//        )).orElseGet(() -> ResponseEntity.status(404).body(
//                new ApiResponse<>("error", HttpStatus.BAD_REQUEST, "Promotion not found", null)
//        ));
//    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<ApiResponse<Void>> deletePromotion(@PathVariable Long id) {
//        Optional<Promo> promo = promoService.findById(id);
//        if (promo.isPresent()) {
//            promoService.delete(promo.get().getId());
//            return ResponseEntity.ok(
//                    new ApiResponse<>("success", HttpStatus.ACCEPTED, "Promotion deleted successfully", null)
//            );
//        } else {
//            return ResponseEntity.status(404).body(
//                    new ApiResponse<>("error", HttpStatus.BAD_REQUEST, "Promotion not found", null)
//            );
//        }
//    }

//    @PutMapping("/{id}")
//    public ResponseEntity<ApiResponse<Promo>> updatePromotion(@PathVariable Long id, @RequestBody Promo promo) {
//        promo.setId(id);
//        Promo updatedPromo = promoService.update(id ,promo);
//        return ResponseEntity.ok(
//                new ApiResponse<>("success", HttpStatus.ACCEPTED, "Promotion updated successfully", updatedPromo)
//        );
//    }
//    @Operation(summary = "Retrieve a promotion by ID")
//    @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Promotion retrieved successfully")

//    @GetMapping
//    public ResponseEntity<ApiResponse<Iterable<Promo>>> getAllPromotions() {
//        Iterable<Promo> promos = promoService.findAll();
//        return ResponseEntity.ok(
//                new ApiResponse<>("success", HttpStatus.ACCEPTED, "List of all promotions", promos)
//        );
//    }


    @Override
    protected Promo convertToEntity(PromoDTO promoDTO) {
        return  null;
    }

    @Override
    protected PromoDTO convertToDto(Promo entity) {
        return null;
    }
}
