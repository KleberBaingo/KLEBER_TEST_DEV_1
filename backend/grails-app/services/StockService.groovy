import com.companies.Company
import com.companies.Stock
import java.time.temporal.ChronoUnit
import java.time.LocalDateTime
import org.apache.commons.lang.time.StopWatch

class StockService {

    def getStocks(Company company, int numberOfHoursUntilNow) {     
        //inicia o stopwatch
        def stopWatch = new StopWatch()
        stopWatch.start()        

        // calcula a data e hora para o período de tempo especificado
        def now = LocalDateTime.now()
        def startTime = now.minusHours(numberOfHoursUntilNow)

        // recupera as cotações de ações para a empresa e período de tempo especificados
        def stocks = Stock.findAllByCompanyAndPriceDateGreaterThanEquals(company, startTime)
          
        //imprime cada cotação de ação no console
        stocks.each { stock ->
           println "Stock price: ${stock.price} - Date: ${stock.company.name}"
        }
        // calcula o tempo total de execução em milissegundos  
        stopWatch.stop()
        long duration = stopWatch.getTime()       

        // imprime o tempo total de execução e o número de cotações de ações recuperadas no console
            println "Total execution time: ${duration}ms - Number of stocks retrieved: ${stocks.size()}"

        //imprime todas as stocks do banco - teste
        //Stock.list().reverse().each { stock ->
        //    println "Stock: $stock.price - ${stock.company.name} - ${stock.priceDate}"
        //}           
        return stocks
    }
}