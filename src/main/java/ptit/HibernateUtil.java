//package ptit;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.Configuration;
//@SuppressWarnings("unused")
//public class HibernateUtil {
//
//	
//		
//		 private static final SessionFactory sessionFactory;
//		    
//		    static {
//		        try {
//		            // Create the SessionFactory from standard (hibernate.cfg.xml) 
//		            
//		            sessionFactory = new Configuration().configure().buildSessionFactory();
//		        } catch (Throwable ex) {
//		            // Log the exception. 
//		            System.err.println("Initial SessionFactory creation failed." + ex);
//		            throw new ExceptionInInitializerError(ex);
//		        }
//		    }
//		    
//		    public static SessionFactory getSessionFactory() {
//		        return sessionFactory;
//		    }
//}
//
