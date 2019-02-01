package com.spaceship.util;

import java.util.HashMap;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.spaceship.model.board.Spaceship;

public class SpaceshipsLoader extends DefaultHandler {

    private static final String SPACESHIP_PROP = "spaceship";
    private static final String NAME = "name";
    private static final String ROW = "row";
    private static final String COL = "col";
    private static final String ID = "id";
    private static final String INDEX = "index";


    private boolean bIndex = false;
    private int currentRow = 0;
    private int currentCol = 0;

    private Map<String, Spaceship> spaceShipMap = null;
    private Spaceship spaceShip = null;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (SPACESHIP_PROP.equalsIgnoreCase(qName)) {
            String name = attributes.getValue(NAME);
            Integer rows = Integer.parseInt(attributes.getValue(ROW));
            Integer cols = Integer.parseInt(attributes.getValue(COL));
            Integer id = Integer.parseInt(attributes.getValue(ID));

            // initialize Spaceship object and set id attribute
            spaceShip = new Spaceship();
            spaceShip.setName(name);
            spaceShip.setBoard(new String[rows][cols]);
            spaceShip.setCols(cols);
            spaceShip.setRows(rows);
            spaceShip.setId(id);

            // initialize list
            if (spaceShipMap == null) {
                spaceShipMap = new HashMap<>();
            }
        } else if (ROW.equalsIgnoreCase(qName)) {
            currentRow = Integer.parseInt(attributes.getValue(ID));
        } else if (INDEX.equalsIgnoreCase(qName)) {
            currentCol = Integer.parseInt(attributes.getValue(ID));
            bIndex = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (SPACESHIP_PROP.equalsIgnoreCase(qName)) {
            spaceShipMap.put(spaceShip.getName(), spaceShip);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (bIndex) {
            spaceShip.getBoard()[currentRow][currentCol] = new String(ch, start, length);
            bIndex = false;
        }
    }

    /**
     * @return the spaceShipMap
     */
    public Map<String, Spaceship> getSpaceShipMap() {
        return spaceShipMap;
    }
}
