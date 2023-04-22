import groovy.json.JsonBuilder
import com.companies.Company
import grails.converters.JSON
import io.micronaut.spring.tx.annotation.Transactional

class CompanyController {
    
    def companyService

    @Transactional
    def getCompanies() {
        def companies = Company.list()
        // passar por companies e criar o json com todas as companies e o desvio padrao de cada uma
        def companiesWithStdDev = companies.collect {
            def stdDev = companyService.calculateStandardDeviation(it)
            [
                company: it,
                stdDev: stdDev
            ]
        }
        //autorizar o front
        response.addHeader("Access-Control-Allow-Origin", "*")

        render companiesWithStdDev as JSON
    }
}
