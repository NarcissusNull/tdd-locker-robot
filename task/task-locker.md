### 正常存
Given：一个有空位的locker

When：存包

Then：得到一个ticket，locker可用容量减一

### 存满
Given：一个没有空位的locker

When：存包

Then：提示存满

### 正常取
Given：一张有效的ticket

When：取包

Then：ticket失效，locker可用容量加一

### 无效ticket取包
Given：一张无效的ticket

When：取包

Then：提示ticket无效


