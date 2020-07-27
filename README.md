extract "\\s+" to WORD_SPLIT  

extract " " to BLANK_SPACE  ,  
"Calculate Error" to CALCULATE_ERROR ,   
"\n" to DELIMITER  

modify arr to words ; s to word  

modify map to wordMap  

modify wordInfoList to wordInfos  

modify Input class to WordInfo class  

delete useless notes  

modify w1 to firstWordInfo; w2 to secondWordInfo  

modify w to word; i to count  

modify list to tempWordInfos