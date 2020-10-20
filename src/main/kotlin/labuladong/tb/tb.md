# 回溯算法
```python

/**
    result: 结果列表
    path: 已经做出的选择
    selections: 剩余选择的项
    delete: 撤销选择
*/
def result[] 
def backTrace(path, selections[])
    if(end condition fufiled) {
        result.add(path)
    }
    for(selection in selections) {
        backTrace(path, selections)
    }    
    delete selection
```


