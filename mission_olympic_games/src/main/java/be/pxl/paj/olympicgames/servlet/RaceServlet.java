package be.pxl.paj.olympicgames.servlet;

import be.pxl.paj.olympicgames.api.data.RaceDTO;
import be.pxl.paj.olympicgames.api.data.RaceResultDTO;
import be.pxl.paj.olympicgames.api.data.RaceResultsDTO;
import be.pxl.paj.olympicgames.domain.ScoreStatus;
import be.pxl.paj.olympicgames.exception.NotFoundException;
import be.pxl.paj.olympicgames.service.OlympicGamesService;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/RaceResults") // ?race=1
public class RaceServlet extends HttpServlet implements ServletContextListener {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm");
    private static final Logger LOGGER = LogManager.getLogger(RaceServlet.class);

    private final OlympicGamesService olympicGamesService;

    public RaceServlet(OlympicGamesService olympicGamesService) {
        this.olympicGamesService = olympicGamesService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        Long raceId = Long.parseLong(req.getParameter("race"));

        writeHeader(writer);

        RaceResultsDTO raceResults;
        try {
            raceResults = olympicGamesService.getRaceById(raceId);
            writeBody(writer, raceResults);
        } catch (NotFoundException notFoundException) {
            writer.println("<h1>" + notFoundException.getMessage() + "</h1>");
        }
        writeFooter(writer);
    }

    private void writeBody(PrintWriter writer, RaceResultsDTO raceResults) {
        writer.println("<h3>" + raceResults.getDiscipline() + " " + DATE_TIME_FORMATTER.format(raceResults.getDateTime()) + "</h3>");
        writer.println("<table>");

        List<RaceResultDTO> sortedRaceResults = raceResults.getRaceResults().stream()
                .filter(x -> x.getStatus() != ScoreStatus.DISQUALIFIED)
                .sorted(Comparator.comparing(RaceResultDTO::getTime))
                .toList();

        for (int i = 0; i < raceResults.getRaceResults().size(); i++) {
            writer.println("<tr>");
            writer.println("<td>" + sortedRaceResults.get(i).getName() + " " + sortedRaceResults.get(i).getTime() + "</td>");
            writer.println("<td>" + sortedRaceResults.get(i).getCountry() + sortedRaceResults.get(i).getTime() + "</td>");
            writer.println("<td>" + sortedRaceResults.get(i).getStatus() + sortedRaceResults.get(i).getTime() + "</td>");
            writer.println("</tr>");
        }
        writer.println("</table>");
    }

    private void writeHeader(PrintWriter writer) {
        writer.println("<html><head><title>Races</title></head><body>");
    }

    private void writeFooter(PrintWriter writer) {
        writer.println("</body></html>");
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        LOGGER.info("Initialize OlympicGamesServlet...");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        LOGGER.info("Destory OlympicGamesServlet...");
    }
}

