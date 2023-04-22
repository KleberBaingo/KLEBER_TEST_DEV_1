import io.micronaut.spring.tx.annotation.Transactional
import com.companies.Company
import grails.converters.JSON

// somente leitura dos dados
@Transactional(readOnly=true)

class StockController {

    def stockService

    def getStocks() {
        //pegar parametros company e ultimas horas, da url
        def companyName = params.company
        def company = Company.findByName(companyName)
        def numberOfHoursUntilNow = params.int('numberOfHoursUntilNow')    

        //tratamento caso nao exista company
        if (!company) {
            render "Company not found"
            return
        }         
        // crirar lista de stocks dessas ultimas x horas 
        def stocks = stockService.getStocks(company, numberOfHoursUntilNow)

        //rendpoint que retorna os dados das stocks retornadas, mas não foi necessárioo uso para o desafio
        //render stocks as JSON
    }
}
