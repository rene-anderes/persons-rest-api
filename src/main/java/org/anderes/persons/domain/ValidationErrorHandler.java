package org.anderes.persons.domain;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class ValidationErrorHandler implements ErrorHandler{
    
   public void warning(SAXParseException exception) throws SAXException {
       // nothing to do...
   }
 
   public void error(SAXParseException exception) throws SAXException {
       throw new PersonValidationException(exception.getLocalizedMessage(), exception);
   }
 
   public void fatalError(SAXParseException exception) throws SAXException {
       throw new PersonValidationException(exception.getLocalizedMessage(), exception);
   }

}

