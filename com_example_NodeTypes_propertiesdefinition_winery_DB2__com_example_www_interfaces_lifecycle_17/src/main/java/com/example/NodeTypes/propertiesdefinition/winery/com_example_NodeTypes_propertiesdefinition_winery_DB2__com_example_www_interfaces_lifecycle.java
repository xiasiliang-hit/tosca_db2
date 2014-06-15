package com.example.NodeTypes.propertiesdefinition.winery;

import java.util.HashMap;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.ws.soap.SOAPFaultException;

import com.jcraft.jsch.JSchException;

import aws.ec2linux.EC2LinuxIAService;

@WebService
public class com_example_NodeTypes_propertiesdefinition_winery_DB2__com_example_www_interfaces_lifecycle extends AbstractIAService 
{
	private String installSFile = "install.sh";
	private String startSFile = "start.sh";
	private String stopSFile="stop.sh";
	private String restartSFile = "restart.sh";
	private String createdbSFile = "createdb.sh";
	private String uninstallSFile = "deinstall.sh";
	private String configSFile = "config.sh";

	
	//static private String host = "192.168.209.227";
	//static private String abPath = "/home/danny/work/eclipse_space1/com_example_NodeTypes_propertiesdefinition_winery_DB2__db2service/py/script/";
	static private String abPath = "./DA/script/";
	static private String toPath = "./";
	
	//String privateKey = ".ssh/id_rsa";
	//static private String sshKey = "./DA/siliang0.pem";
	//static private String sshKey = "MIIEogIBAAKCAQEAltRnlqp7bgyG2QGTtG7jePyPkyu5rlRVUBTcKlpXTC1xUESeN042d7RMW2I1FZXL+B/v5yhvhqgGtyeXv5yoL6hdjVNAfhJ8CrNXPlRepP3BYci3lxT3kvxVhagmRos8QTpp4HrmICRVWx0i5ITiB9bIoIaH3bVBYRJfylGUlqC1FQ3dtTI7qv6Sr7TGZtMZpwE54QS+7kYJvOM0UhfDfyWTLB2wzfeym4BAICu/VL0Eedu7uaDBkn9kBDas8tnxRyQTKTh4ELETY4cc+I0dSvCEgxqUrVlUegBgCmbrZ0+resSmUHBSgmz8juQ/47KG6rCxJCWArsE4ZothFzWIrQIBIwKCAQB8+SKhaK9pz91x+f4Kh8PKpWEE6bcbanKSz3SYHvfgCGUz4RVhBkpjLv1wSg66HQgWu2BgcfYB263K9Oty4OMgLGrFjh9+ZxZSAk+aC2Rc0kElIqa/Ar6BGjg7i1Lp/lZ/MGZa6XzYzaXPJsUjvo9llLTcxz1f7fRXvsRlzpEPFivMKWxs5ix+vFsTeNLq8HX+INdLAz1vDPiD63VzbSE6fjpcm0OCyw7YC69c4MICNlc0V7YFkRymrTv0hztyDYu8niLoPftTes3bo9RcPWrKrNXAwur53rY3dTq1/Au9wE6Zo0RpRlJxv6ZLIyAejnljId0tiGvMpBkwWX5Uy3SrAoGBAMeozpDCzPedquAchys9lepPk7dJf5M18Hul3wOQ1Uu1Ac6KltnINRZ/lGNtJyxe6d9AussTCdngkKkUlFMyZdCtNK0Q/C0XnMs7lWkywxpGenIV0jg17DfxRQQllzUDM36jk6ziYtw2PBQlofZt9z5dsW3g0fe9GW1U7H1JeCA1AoGBAMFkMJ3zYSABnIJy2ZPHEiVZr840KPwO/0esxLSote6VMyXrI7qCY5vZYixdaBK+MHVbD1uXCxSQfsIGTpZrxOHiblZys7G3o2Fcp5AqU7/siv7LQqH6aSYifVLUNZaQwVJkYxmfjHPmN/OS/WlQ2l3F6AwvruOH6pIviygGTEWZAoGBALaLtYuqygb2jZmzrshy0jVQEgapmTYir/wFXi8lVUyIPCqNVrh8iE8VjvvRgua9LZjquWk1+mDNUQ+dyXCjG0JyeU3GYudmC7J/nowRJ2h685uBqkIFakHGpYAiXlxasrztU9FEAp1zaiEMdtKtrtnvQyKhqgcTSnKWyZcembcLAoGBALZXJoZL3ztvO8tzmfG7sgX1ed+thbp0ikrkuXciuioXpUECRkIjKreD0ZeLRN54zpqJDnrtf3nKER1WZ1qgIAgtQ3YUYEh58dDTs+5Ty06Oka5n371LL/DBbtkROdcaxOdItTVqi727zlqvKXHtJajfKz6wnZSzWYKEmSW8y5ITAoGAQF7T/bztIPWYGkHs8XkGlks7DteTBrI3r21aiQMW8uo/bO4GxkTGR7ylwr7yRL4D8qPGp9y1DnqPWf+rKSSwRspqXVPFQ//H/hP3sanlMH+u2hv2RD9NSFWZtJ6yhOTHXDLgU+dUrSH2aT4SVy8+LNTBdNRgTwgqXQythzeOR0E=";	
	
	private String defaultPort = "50000"; 
	private String DASusername = "db2adm0";
	//private String username = "db2ins0";
	//private String password = "123456";
	//private String instancename = "db2ins0";
	
	@WebMethod
	@SOAPBinding
	@Oneway
	public void install (
		@WebParam(name="targetIP", targetNamespace="http://winery.propertiesdefinition.NodeTypes.example.com/") String targetIP,
		@WebParam(name="sshKey", targetNamespace="http://winery.propertiesdefinition.NodeTypes.example.com/") String sshKey,
		@WebParam(name="sshUser", targetNamespace="http://winery.propertiesdefinition.NodeTypes.example.com/") String sshUser
	) throws DB2Exception {
		// This HashMap holds the return parameters of this operation.
		final HashMap<String,String> returnParameters = new HashMap<String, String>();
		String re = "";
		String success = "false";
		
		EC2LinuxIAService ser = new EC2LinuxIAService();
		ser.transferLocalFolder(targetIP, abPath, toPath, sshKey, sshUser);

		try
		{
			re = ser.runScript(targetIP, "bash " + installSFile, sshKey, sshUser);
			System.out.println(re);
			
			if (re.contains("The execution completed successfully"))
			{
				success = "true";
				System.out.println("install success!");
			}
			else
			{
				success = "false";
			}
		}
		catch (JSchException e)
		{
			// TODO Auto-generated catch block
			System.out.println("!!!ex: install");
			success = "false";
			e.printStackTrace();
			//System.out.println(e.toString());
			
			ExceptionHandle(e);
		}

		returnParameters.put("success", success);

		sendResponse(returnParameters);
	}

	@WebMethod
	@SOAPBinding
	@Oneway
	public void configure(
		@WebParam(name="targetIP", targetNamespace="http://winery.propertiesdefinition.NodeTypes.example.com/") String targetIP,
		@WebParam(name="sshKey", targetNamespace="http://winery.propertiesdefinition.NodeTypes.example.com/") String sshKey,
		@WebParam(name="sshUser", targetNamespace="http://winery.propertiesdefinition.NodeTypes.example.com/") String sshUser,
		@WebParam(name="dbname", targetNamespace="http://winery.propertiesdefinition.NodeTypes.example.com/") String dbname,
		@WebParam(name="db2username", targetNamespace="http://winery.propertiesdefinition.NodeTypes.example.com/") String db2username,
		@WebParam(name="db2pwd", targetNamespace="http://winery.propertiesdefinition.NodeTypes.example.com/") String db2pwd
	)   throws DB2Exception {
		final HashMap<String,String> returnParameters = new HashMap<String, String>();
		String re = "";
		//start(targetIP, sshKey, sshUser);
		
		String success = "false";
		EC2LinuxIAService ser = new EC2LinuxIAService();

		
		try
		{
			if (db2username.length() >= 9)
			{
				throw new DB2Exception(new DB2Fault("<db2ex003>", "db2 user name too long fault"));
			}
			
			String cmd = "bash " + configSFile + " " + db2username + " " + db2pwd;
			
			re = ser.runScript(targetIP, cmd , sshKey, sshUser);
			System.out.println(re);
			
			if (re.contains("The execution completed successfully."))
			{
				System.out.println("config success!");
				//success = "true";
			}
			else
			{
				success = "false";
			}
		} catch (JSchException e)
		{
			// TODO Auto-generated catch block
			System.out.println("!!!ex: config");
			success = "false";
			e.printStackTrace();
			
			ExceptionHandle(e);
		}
		
		
		try
		{
			re = ser.runScript(targetIP, "bash " + startSFile, sshKey, sshUser);
			System.out.println(re);
			
			if (re.contains("DB2START processing was successful"))
			{
				//System.out.println("start success!");
				//success = "true";
			}
			else
			{
				success = "false";
			}
		} catch (JSchException e)
		{
			// TODO Auto-generated catch block
			System.out.println("!!!ex: start");
			success = "false";
			e.printStackTrace();
			
		}
		
		// TODO: Implement your operation here.
		if (createdb(targetIP,  dbname,  sshKey,  sshUser, re) == "true")
			{
				success = "true";
				System.out.println("db2 configuration success!");
			}
		else
		{
			success = "false";
		}
		
		
		try
		{
			re = ser.runScript(targetIP, "bash " + stopSFile, sshKey, sshUser);
			System.out.println(re);
			
			if (re.contains("DB2STOP processing was successful"))
			{
				success = "true";
				//System.out.println("stop sucess!");
			}
			else
			{
				success = "false";
			}
			
		} catch (JSchException e)
		{
			// TODO Auto-generated catch block
			System.out.println("!!!ex: stop");
			success = "false";
			e.printStackTrace();
		}
		
		
		returnParameters.put("port", defaultPort);

		// Output Parameter 'DASusername' (optional)
		// TODO: Set DASusername parameter here.
		// Do NOT delete the next line of code. Set "" as value if you want to return nothing or an empty result!
		returnParameters.put("DASusername", DASusername);

		returnParameters.put("success", success);

		sendResponse(returnParameters);
	}

	@WebMethod
	@SOAPBinding
	@Oneway
	public void start(
		@WebParam(name="targetIP", targetNamespace="http://winery.propertiesdefinition.NodeTypes.example.com/") String targetIP,
		@WebParam(name="sshKey", targetNamespace="http://winery.propertiesdefinition.NodeTypes.example.com/") String sshKey,
		@WebParam(name="sshUser", targetNamespace="http://winery.propertiesdefinition.NodeTypes.example.com/") String sshUser
	) throws DB2Exception{
		final HashMap<String,String> returnParameters = new HashMap<String, String>();
		String re = "";
		// TODO: Implement your operation here.
		
		String success = "false";
		EC2LinuxIAService ser = new EC2LinuxIAService();

		try
		{
			re = ser.runScript(targetIP, "bash " + startSFile, sshKey, sshUser);
			System.out.println(re);
			
			if (re.contains("DB2START processing was successful") || re.contains("The database manager is already active"))
			{
				success = "true";
				System.out.println("start success!");
			}
			else
			{
				success = "false";
			}
		} catch (JSchException e)
		{
			// TODO Auto-generated catch block
			System.out.println("!!!ex: start");
			success = "false";
			e.printStackTrace();
		}

		// Output Parameter 'sucess' (optional)
		// TODO: Set sucess parameter here.
		// Do NOT delete the next line of code. Set "" as value if you want to return nothing or an empty result!
		//returnParameters.put("sucess", success);
		// TODO: Implement your operation here.


		// Output Parameter 'success' (optional)
		// TODO: Set success parameter here.
		// Do NOT delete the next line of code. Set "" as value if you want to return nothing or an empty result!
		returnParameters.put("success", success);

	
		sendResponse(returnParameters);		
	}

	@WebMethod
	@SOAPBinding
	@Oneway
	public void stop(
		@WebParam(name="targetIP", targetNamespace="http://winery.propertiesdefinition.NodeTypes.example.com/") String targetIP,
		@WebParam(name="sshKey", targetNamespace="http://winery.propertiesdefinition.NodeTypes.example.com/") String sshKey,
		@WebParam(name="sshUser", targetNamespace="http://winery.propertiesdefinition.NodeTypes.example.com/") String sshUser
	) throws DB2Exception {
		final HashMap<String,String> returnParameters = new HashMap<String, String>();
		String re = "";	
		// TODO: Implement your operation here.
		String success = "false";
		EC2LinuxIAService ser = new EC2LinuxIAService();

		try
		{
			re = ser.runScript(targetIP, "bash " + stopSFile, sshKey, sshUser);
			System.out.println(re);
			
			if (re.contains("DB2STOP processing was successful"))
			{
				success = "true";
				System.out.println("stop success!");
			}
			else
			{
				success = "false";
			}
			
		} catch (JSchException e)
		{
			// TODO Auto-generated catch block
			System.out.println("!!!ex: stop");
			success = "false";
			e.printStackTrace();
		}

// Output Parameter 'success' (optional)
// TODO: Set success parameter here.
// Do NOT delete the next line of code. Set "" as value if you want to return nothing or an empty result!
returnParameters.put("success", success);


sendResponse(returnParameters);
}

	@WebMethod
	@SOAPBinding
	@Oneway
	public void uninstall(
		@WebParam(name="targetIP", targetNamespace="http://winery.propertiesdefinition.NodeTypes.example.com/") String targetIP,
		@WebParam(name="sshKey", targetNamespace="http://winery.propertiesdefinition.NodeTypes.example.com/") String sshKey,
		@WebParam(name="sshUser", targetNamespace="http://winery.propertiesdefinition.NodeTypes.example.com/") String sshUser
	) throws DB2Exception {
		// This HashMap holds the return parameters of this operation.
		final HashMap<String,String> returnParameters = new HashMap<String, String>();
		String re = "";
		// TODO: Implement your operation here.
		String success = "true";
		EC2LinuxIAService ser = new EC2LinuxIAService();

		try
		{
			re = ser.runScript(targetIP, "bash " + uninstallSFile, sshKey, sshUser);
			System.out.println(re);
			
			if (re.contains("The execution completed successfully"))
			{
				success = "true";
				System.out.println("uninstall success!");
			}
			else
			{
				success = "false";
			}
			
		} catch (JSchException e)
		{
			// TODO Auto-generated catch block
			System.out.println("!!!ex: uninstall");
			success = "false";
			e.printStackTrace();
		}

		// Output Parameter 'success' (optional)
		// TODO: Set success parameter here.
		// Do NOT delete the next line of code. Set "" as value if you want to return nothing or an empty result!
		returnParameters.put("success", success);


		sendResponse(returnParameters);	
		}

	@WebMethod
	@SOAPBinding
	@Oneway
	public void restart(
		@WebParam(name="targetIP", targetNamespace="http://winery.propertiesdefinition.NodeTypes.example.com/") String targetIP,
		@WebParam(name="sshKey", targetNamespace="http://winery.propertiesdefinition.NodeTypes.example.com/") String sshKey,
		@WebParam(name="sshUser", targetNamespace="http://winery.propertiesdefinition.NodeTypes.example.com/") String sshUser
	) throws DB2Exception {
		// This HashMap holds the return parameters of this operation.
		final HashMap<String,String> returnParameters = new HashMap<String, String>();
		String re = "";
		// TODO: Implement your operation here.
		String success = "false";
		EC2LinuxIAService ser = new EC2LinuxIAService();

		try
		{	
			re = ser.runScript(targetIP, "bash " + restartSFile, sshKey, sshUser);
			System.out.println(re);
			
			if (re.contains("The database manager is already active") || re.contains("DB2START processing was successful"))
			{
				success = "true";
				System.out.println("restart success!");
			}
			else
			{
				success = "false";
			}
			
		} catch (JSchException e)
		{
			// TODO Auto-generated catch block
			System.out.println("!!!ex: restart");
			success = "false";
			e.printStackTrace();
		}

	returnParameters.put("success", success);
	
	
	sendResponse(returnParameters);
	}



	private String createdb(String targetIP, String dbname, String sshKey, String sshUser, String resultStr)
	{
		String re = "";
		String success = "false";
		EC2LinuxIAService ser = new EC2LinuxIAService();
	
		try
		{
			String cmd = "bash " + createdbSFile + " " + dbname;
			
			re = ser.runScript(targetIP, cmd, sshKey, sshUser);
			System.out.println(re);
			resultStr = re;
			
			if (re.contains("The CREATE DATABASE command completed successfully"))
			{
				success = "true";
				System.out.println("createdb success!");
			}
			else
			{
				success = "false";
			}
			
		} catch (JSchException e)
		{
			// TODO Auto-generated catch block
			System.out.println("!!!ex: createdb");
			success = "false";
			e.printStackTrace();
		}
		return success;

	}

	//wrap errors into self-defined DB2 exceptions
	private void ExceptionHandle(JSchException e) throws DB2Exception
	{
		
		System.out.println("123123123works");
		
		if (e.toString().contains("No route to host") || e.toString().contains("Connection timed out"))
		{
	        throw new DB2Exception(new DB2Fault("<db2ex001>", "unknown host fault"));
		}
		else if (e.toString().contains("Auth fail"))
		{
	        throw new DB2Exception(new DB2Fault("<db2ex002>", "ssh user fault"));
		}
		else
		{
			throw new DB2Exception(new DB2Fault("<db2ex099>", "unknown fault"));
		}
	}
	
}
