package qotd

import grails.transaction.Transactional

@Transactional
class QuoteService {

    def serviceMethod() {

    }

    def getStaticQuote() {
        return new Quote(author: "Anonymous",
                content: "Real Programmers Don't eat much quicheQuiche")
    }

    def getRandomQuote(){

        def allQuotes = Quote.list()
        def randomQuote

        if (allQuotes.size() > 0){

            def randomIdx = new Random().nextInt(allQuotes.size())
            randomQuote = allQuotes[randomIdx]

        }else{
            randomQuote = new Quote(author: "Anonymous",
                    content: "Real Programmers don't eat much Quiche")        }





        return randomQuote;
    }


}
