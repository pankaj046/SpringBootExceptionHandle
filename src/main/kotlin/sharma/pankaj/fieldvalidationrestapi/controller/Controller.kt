package sharma.pankaj.fieldvalidationrestapi.controller

import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import sharma.pankaj.fieldvalidationrestapi.model.RequestModel
import sharma.pankaj.fieldvalidationrestapi.model.ResponseModel
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class Controller {

    @Validated
    @PostMapping("/fields")
    fun getData(@RequestBody request : @Valid RequestModel) :ResponseEntity<ResponseModel>{

        return ResponseEntity.ok(ResponseModel(false, ""+(1/0)))
    }
}