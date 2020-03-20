import model.ScrappedPage;
import model.WebScrapperState;
import services.InputArgsService;
import services.OutputService;
import services.WebScrapingService;

public class Main {
    public static void main(String[] args) {

        switch (args.length) {

            case 0: throw new IllegalArgumentException("Please provide URL of downloading resource. " +
                    "For help use command -h.");

            case 1: {
                if (args[0].equals("-h")) {
                    OutputService.ConsoleHelp();
                } else {
                    callScrapper(args);
                }
                break;
            }

            case 2:
            case 3:
            case 4:
            case 5:{
                if (args[0].equals("-h")) {
                    throw new IllegalArgumentException("-h command has no arguments! For help use command -h.");
                } else {
                    callScrapper(args);
                }
                break;
            }

            default:
                throw new IllegalArgumentException("You can’t input more than 5 parameters! For help use command -h.");

        }
    }

    private static void callScrapper(String[] args) {
        WebScrapperState state = InputArgsService.parse(args);
        ScrappedPage page = WebScrapingService.Scrap(state);
        OutputService.Output(state, page);
    }
}
