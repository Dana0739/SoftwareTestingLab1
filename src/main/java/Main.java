import Services.OutputService;

public class Main {
    public static void main(String[] args) {
        switch (args.length) {

            case 0: throw new IllegalArgumentException("Please provide URL of downloading resource. " +
                    "For help use command -h.");

            case 1: {
                if (args[0].equals("-h")) {
                    OutputService.ConsoleHelp();
                } else if (args[0].equals("-f") || args[0].equals("-c")) {
                    throw new IllegalArgumentException("Please provide URL of downloading resource first. " +
                            "For help use command -h.");
                } else {
                    OutputService.ConsoleOutput(); //web scraper function call + write in console
                }
                break;
            }

            case 2: {
                if (args[0].equals("-h")) {
                    throw new IllegalArgumentException("-h command has no arguments! For help use command -h.");
                } else if (args[0].equals("-f") || args[0].equals("-c")) {
                    throw new IllegalArgumentException("Please provide URL of downloading resource first. " +
                            "For help use command -h.");
                } else {
                    if (args[1].equals("-f")) {
                        OutputService.FileOutput(); //web scraper function call + write in file
                    } else if (args[1].equals("-c")) {
                        OutputService.ConsoleOutput(); //web scraper function call + write in console
                    } else {
                        throw new IllegalArgumentException("Second parameter have to me -c or -f! " +
                                "For help use command -h.");
                    }
                }
                break;
            }

            case 3: {
                if (args[0].equals("-h")) {
                    throw new IllegalArgumentException("-h command has no arguments! For help use command -h.");
                } else if (args[0].equals("-f") || args[0].equals("-c")) {
                    throw new IllegalArgumentException("Please provide URL of downloading resource first. " +
                            "For help use command -h.");
                } else {
                    if (args[1].equals("-f")) {
                        String filename = args[2];
                        OutputService.FileOutput(); //web scraper function call + write in file + filename!!!
                    } else if (args[1].equals("-c")) {
                        throw new IllegalArgumentException("There’s no third argument using command -c! " +
                                "For help use command -h.");
                    } else {
                        throw new IllegalArgumentException("Second parameter have to me -c or -f! " +
                                "For help use command -h.");
                    }
                }
                break;
            }

            default:
                throw new IllegalArgumentException("You can’t input more than 3 parameters! For help use command -h.");

        }
    }
}
