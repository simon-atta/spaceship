package com.spaceship.util;

import java.io.IOException;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import com.spaceship.model.board.Spaceship;

/**
 * This is spaceship factory used to load all spaceships definition on XL
 * spaceship bootstrap
 * {@link com.spaceship.XlSpaceshipApplication#main(String[])}
 * <p>
 * It will create one instance of board into memory as spaceship map, key will
 * be spaceship name and value will spaceship details.
 * <p>
 * This factory will be able to get all have most common operations for board.
 */
@Component
public class SpaceshipFactory {

    private static final Logger LOGGER = Logger.getLogger(SpaceshipFactory.class);
    private static final String FILE_PATH = "spaceships.xml";

    private static Map<String, Spaceship> spaceshipMap = null;
    private static SpaceshipsLoader readXMLFile;

    private SpaceshipFactory() {
        readXMLFile = new SpaceshipsLoader();
    }

    private static void getSpaceshipsShapes() {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            saxParser.parse(new ClassPathResource(FILE_PATH).getInputStream(), readXMLFile);
            spaceshipMap = readXMLFile.getSpaceShipMap();
        } catch (ParserConfigurationException | SAXException | IOException e) {
            LOGGER.error(e);
        }
    }

    /**
     * This method will look over spaceship map by space ship name.
     *
     * @param spaceShipName
     *        String
     * @return spaceship.
     */
    public static Spaceship getSpaceships(String spaceShipName) {
        if (spaceshipMap == null) {
            getSpaceshipsShapes();
        }

        return spaceshipMap.get(spaceShipName);
    }

    public static Map<String, Spaceship> getSpaceships() {
        if (spaceshipMap == null) {
            getSpaceshipsShapes();
        }

        return spaceshipMap;
    }

}
