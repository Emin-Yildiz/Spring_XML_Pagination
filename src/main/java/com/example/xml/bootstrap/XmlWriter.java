//package com.example.xml.bootstrap;
//
//import com.github.javafaker.Faker;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.transform.Transformer;
//import javax.xml.transform.TransformerFactory;
//import javax.xml.transform.dom.DOMSource;
//import javax.xml.transform.stream.StreamResult;
//import java.io.File;
//import java.util.Random;
//
//@Component
//public class XmlWriter implements ApplicationRunner {
//    private final Faker faker;
//    Random r=new Random(); //random sınıfı
//    Boolean state = true;
//
//    public XmlWriter(Faker faker){
//        this.faker = faker;
//    }
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        try {
//            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder builder = factory.newDocumentBuilder();
//            Document document = builder.newDocument();
//
//            Element rootElement = document.createElement("users");
//            document.appendChild(rootElement);
//
//            for (int i = 0; i < 100; i++) {
//
//                String username = faker.name().fullName();
//                String address = faker.address().streetAddress();
//                int age =r.nextInt(70);
//                long password = r.nextLong(9999);
//                if(state){
//                    state = false;
//                }else {
//                    state = true;
//                }
//
//                Element user = document.createElement("user");
//                rootElement.appendChild(user);
//
//                Element usernameElement = document.createElement("username");
//                usernameElement.setTextContent(username);
//                user.appendChild(usernameElement);
//
//                Element passwordElement = document.createElement("password");
//                passwordElement.setTextContent(String.valueOf(password));
//                user.appendChild(passwordElement);
//
//                Element addressElement = document.createElement("address");
//                addressElement.setTextContent(address);
//                user.appendChild(addressElement);
//
//                Element ageElement = document.createElement("age");
//                ageElement.setTextContent(String.valueOf(age));
//                user.appendChild(ageElement);
//
//                Element isLive = document.createElement("islive");
//                isLive.setTextContent(String.valueOf(state));
//                user.appendChild(isLive);
//            }
//
//            // XML dosyasına yazma işlemi
//            TransformerFactory transformerFactory = TransformerFactory.newInstance();
//            Transformer transformer = transformerFactory.newTransformer();
//            DOMSource source = new DOMSource(document);
//            StreamResult result = new StreamResult(new File("users.xml"));
//            transformer.transform(source, result);
//
//            System.out.println("XML dosyası oluşturuldu.");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
