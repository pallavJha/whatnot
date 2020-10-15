*
<Slide 0>
1. We'll talk about Mission Control, it's Features and then we'll move to the actual demo of Mission Control.
</Slide 0>

<Slide 1>
2. As an Automation company, we've been creating and deploying various Automation Systems. While doing so we found that in the RUN phase it'll be very helpful for the production teams if there's a system that can monitor and take corrective actions if something goes wrong. And this where Mission Control comes in.
3. Mission Control is the tool that we use for monitoring the Automation Systems.
4. And While you're monitoring the automation systems and its infrastructure, you can also take actions on them be it on a single application, machine or a pool of servers and this is the control aspect of Mission Control.
5. The resource that are being monitored by Mission Control are not just limited to only the Soroco Automation Systems. It can be used to monitor all the different types of enterprise applications.
</Slide 1>

<Slide 2>
6. So, Mission Control uses agents to monitor and take actions on the machines and then it also uses agent-less solutions for legacy applications or software appliances.
7. And that makes it scale easily to 100s and 1000s of servers. These resources be it, automation systems, applications or the software appliances, are presented in the Mission Control's Dashboard in a very customizable hierarchy. 
8. Depending on your needs you can customize this hierarchy so that it makes sense to you.
9. And this way Mission Control becomes the Single Pane of glass to monitor and control your resources.
</Slide 2>

<Slide 3>
9.1 Integrations
10. Mission Control comes up with a wide variety of integration with multiple platforms and technologies.
11. It can be integrated with different RPA vendors, relational databases,  automation servers, web servers and any kind of hardware or software appliances.
12. The agents, that are used for monitoring and control, are very light weight and it can be installed on Windows, Linux and Solaris machines out of the box.
13. And once the integrations are done then related metrics will start showing up on the Dashboard in the form of configurable graphs and cards. These metrics can further be used to set up alerts and self healing scripts.
14. The data flow for the graphs or the executions that Mission Control triggers on the resouces, all of these actions are access controlled and it can be merged with the Organizations LDAP groups as well. 
</Slide 3>


<Slide 4>
3.0. Now that you're Aware of Mission Control, Let's look into a Real World problem that it has solved.
3.1. This is one of the case studies why one of the largest card payments firm is using Mission Control.
3.2. The application that they had deployed spanned multiple locations, networks and teams and due to that the identification of the faults, root cause analysis and fixes required good amount of tools and it took hours or days to complete.
3.3. This is where Mission Control became a good fit
3.4. They started using the configurable dashboards for monitoring and with that they configured Mission Control to execute self healing actions and workflow and this way the dependency between the teams and tools reduced a lot.
</Slide 4>




<Demo>
	<Scheduled Scripts>
		Just like you can execute an script at any given moment, you can schedule the scripts to be executed at a future time, just like you would schedule meetings in the Outlook Calendar.

		You can select the scripts, and then select the recurrence pattern for the schedule as Hourly, Daily or Monthly .
	</Scheduled Scripts>
	<Git Integration>
		We've created these scripts in Mission Control.	There can be some scenarios in which you would not like to copy paste the script contents in Mission Control as they are already present in your git repositories.
		To handle those scenarios Mission Control can be configured to pick up the scripts from Git Repositories as well.
	</Git Integration>
	<Alerting>
		So, what happened under the hood is Mission Control has executed one self healing script as soon as it became aware that the load average was high.
		**Go to the alert Page**
		To get more details more about it, Let's go to the alert page. Here we've configured the script to  pause the automation system whenever the load average is more than 20 for the last 1 minute.

		**Stop the Load**
		Let me stop the high load so that the Automation System is resumed 
	</Alerting>
	<Workflow>

	</Workflow>
	<Workflow>
		
	</Workflow>
	<Self Service>
	
	</Self Service>
	<Autoscaling>
		season traffic and high load only for some duration
		in those scenarios you'd probably be using AWS Elastic Load Balancer or Auto Scaling Groups.

		In those scenarois your entities will be ephemeral
		and Mission Control has seamless support for that as well.
		
		You can create custom view configuration for those types of entities and it will applied to them whenever are up and running.
		compliant to autoscaling
	</Autoscaling>
	<RBAC>
	</RBAC>
</Demo>

Alerting

Workflow Execution



agent download can be done

Self Service
Autoscaling
Touch RBAC - As mention in the slides.


Add the deployments types: in slide 3 - Cloud and Internal deployments
Mention: SAP, Web Application
Replace Tecnologies -> Platforms
Polish 3rd slide, add better name and categories
Highlight Console Based Approach
Add Self Service in the Enterprise Ready Features
Think through slide 4
Add narrative about Disaster Recovery and HA















































1. We'll talk about Mission Control, it's Features and then we'll move to the actual demo of Mission Control
2. We've built Mission Control to monitor the Automation Systems and the under lying infrastructure.
3. Idea, gap came up, visulize and monitor
4. 
5. Single platform to solve the problem the 


5. Multiple Locations
6. Single Dashboard seamless error free 

now you;re aware, let's look into the RW problem, 

add the rollback and resume workflow







Login
	Systems - Talk about classification
	Hierarchy
CC -> AS -> Application
	Features
Configurable Dashboards
		Tabs
		Execute Actions
			Execute Start Load Script
Scheduled Scripts
Git Integration
Alerting
Workflow Execution
Self Service
Autoscaling
Touch RBAC
