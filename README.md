extract "\\s+" to WORD_SPLIT  

extract " " to BLANK_SPACE  ,  
"Calculate Error" to CALCULATE_ERROR ,   
"\n" to DELIMITER  

modify arr to words ; s to word  

modify map to wordMap  

modify wordInfoList to wordInfos  

modify Input class to WordInfo class