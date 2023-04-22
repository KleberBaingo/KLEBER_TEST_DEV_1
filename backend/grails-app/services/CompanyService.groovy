import com.companies.Company
import com.companies.Stock

class CompanyService {
    def BootStrap   

    def calculateStandardDeviation(Company company) {
         // buscar todas as ações da empresa
        List<Stock> stocks = new ArrayList<>();
        List<Stock> allStocks = Stock.list();

        for (Stock stock : allStocks) {
            if (stock.getCompany().equals(company)) {
            stocks.add(stock);
            }       
        }       
        // calcular a média das ações
        def average = stocks.collect{it.price}.sum() / stocks.size()

        // calcular o desvio padrão
        def stdDev = Math.sqrt(stocks.collect{ Math.pow(it.price - average, 2) }.sum() / stocks.size())

        return stdDev       
    }
}