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