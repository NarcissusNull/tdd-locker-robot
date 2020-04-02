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



### 顺序存
Given：robot持有两个locker,第一个可用容量大于0，第二个可用容量为0

When：存包

Then：第一个locker做save操作，得到一个ticket

### 存满
Given：robot持有两个locker,第一个可用容量为0，第二个可用容量为0

When：存包

Then：提示存满

### 正常取
Given：robot持有两个locker,一张对于第一个locker有效的ticket

When：取包

Then：第一个locker执行fetch操作

### 无效ticket取包
Given：robot持有两个locker,一张对于两个locker都无效的ticket

When：取包

Then：提示ticket无效