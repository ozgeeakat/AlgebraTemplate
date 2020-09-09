/* --------------------------------------------------------------------------------------------
#Project          : Algebra Android Assignment
#SDK Version      : 30
#File Name        : DataModel.java
#Package          : data
#Author           : Özge AKAT
#Created On       : 2020/09/04

#Description      : Login Page Data Model

#Last Modified By :
#Last Modified On :

#Change Log       :

#Function Params  : loginName --> Valid user name for login. As static final string
-------------------------------------------------------------------------------------------- */
package data;

public class DataModel {
    private final static String loginName = "algebra";
    public static String getLoginName(){
        return loginName;
    }
}
