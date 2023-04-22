import com.companies.Company
import com.companies.Stock
import java.time.temporal.ChronoUnit
import java.time.LocalDateTime

class BootStrap {

    def stockService
    def companyService

    def init = { servletContext ->
        // Criar fake data das companies
        def company1 = new Company(name: "AMAZON", segment: "ecomerce")
        def company2 = new Company(name: "FERRARI", segment:"car")
        def company3 = new Company(name: "TESLA", segment: "car")         

        // Gerar dados falsos para cada empresa
        [company1, company2, company3].each { company ->
            // Iterar pelos últimos 30 dias
            (0..29).each { dayOffset ->
                // Iterar pelas horas de trabalho (10 as 18)
                (10..17).each { hour ->
                    // Iterar pelos minutos de cada hora
                    (0..59).each { minute ->
                        // Gerar um preço aleatório para a cotação
                        def price = new Random().nextDouble() * 100
                        // Criar a cotação de ação com a data e hora correspondentes
                        def priceDate = LocalDateTime.now().minusDays(dayOffset)
                            .withHour(hour)
                            .withMinute(minute)
                            .withSecond(0)
                            .withNano(0)
                       def stock = new Stock(company: company, price: price, priceDate: priceDate).save()
                     
                    }
                }
            }
        }
    }
    def destroy = {
    }
}