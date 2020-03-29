# jenkins-script
run a Jenkins job and print its console output on terminal - Python Script

### Install

<pre>sudo apt install jq</pre>
<pre>sudo apt install curl</pre>

### Clone
<pre>git clone https://github.com/bayramcicek/jenkins-script.git </pre>
<pre>cd ./jenkins-script</pre>

### Run

<pre>/bin/bash ./script_template.sh</pre>

### Result
<pre>

...

<link>/api/json

Started by remote host <ip>
[EnvInject] - Loading node environment variables.
Building in workspace <workspace>

============================= test session starts ==============================
platform linux -- Python 3.6.8, pytest-5.1.2, py-1.8.0, pluggy-0.12.0 -- /usr/bin/python3.6
cachedir: .pytest_cache
rootdir: <rootdir>
collecting ... collected 3 items

../../../../*//::test_setup PASSED
../../../../*//::test_local 

--------------------------------------------------------------

output

--------------------------------------------------------------

PASSED
../../../../*//::test_teardown test completed
PASSED

================== 3 passed, 1 warnings in 134.27s (0:02:14) ===================
Finished: SUCCESS


</pre>
