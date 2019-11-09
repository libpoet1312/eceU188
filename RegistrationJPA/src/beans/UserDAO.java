package beans;

import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.User;
import encrypt.PasswordUtil;
import utils.HibernateUtil;

public class UserDAO {

	/**
	 * Save User
	 * 
	 * @param user
	 */

	public int registerUserHibernate(User user) {

		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// find if user exists
			System.out.println("find if exists");
			User found = findUser(user.getUserName());
			if (found == null) {
				// DEN YPARXEI ARA TON VAZW
				// save the student object
				session.save(user);
				// commit transaction
				transaction.commit();
				//session.close(); 
				return 1;
			} else {
				// Yparxei 
				System.out.println(found.getEmail()+" "+found.getUserName());
				
				return -1;
			}

		} catch (Exception e) {
			if (transaction != null) {
				//transaction.rollback();
				e.printStackTrace();
		}
			
			
		return -1;
			
		}

		
	}

	public static User validate(String email, String password) {

		//Transaction transaction = null;
		User user = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			System.out.println("start a transaction");
			//transaction = session.beginTransaction();
			// get an user object
			user = findUserviaEmail(email);
			
			String hash = user.getPassword();
			// convert password from String to char[]
    		char [] passwordTOHASH = password.toCharArray();
    		
    		
			boolean isMatching = PasswordUtil.Verify(hash, passwordTOHASH);
			
			if (user != null && isMatching) {
				
				// commit transaction
				System.out.println("Valid");
				//transaction.commit();
				session.close(); 
				return user;
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return null;
	}

	public static User findUser(String username) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			User user = (User) session.createQuery("FROM User u where u.username=:username",User.class)
					.setParameter("username", username).uniqueResult();
			//User user = (User) session.get(User.class,username);
			
						
			if (user != null ) {
				// commit transaction
				System.out.println("Found");
				transaction.commit();
				return user;
			}
			

		} catch (Exception e) {
			if (transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();
		}

		return null;
	}
	
	public static User findUserviaEmail(String email) {
		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			User user = (User) session.createQuery("FROM User u where u.email=:email",User.class)
					.setParameter("email", email).uniqueResult();
			//User user = (User) session.get(User.class,username);
			
						
			if (user != null ) {
				// commit transaction
				System.out.println("Found");
				transaction.commit();
				return user;
			}
			

		} catch (Exception e) {
			if (transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();
		}

		return null;
	}
	
}
