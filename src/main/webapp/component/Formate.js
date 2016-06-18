//格式化时间日期
export default{
	number2(num){//数字填充，使之保持2位
	    if (num<10) {
	        return '0'+num;
	    }else{
	        return num;
	    }
	},
	formate(data,type=" "){//数据 类型
		var time=this.number2(data.getHours())+":"+this.number2(data.getMinutes());
		var date=data.getFullYear()+"-"+this.number2((data.getMonth()+1))+"-"+this.number2(data.getDate());
	    if (type==='time') {
	        return time;
	    }else if (type=='date'){
	        return date;
	    }else{
	    	return date+" "+time;
	    }
	}
}
