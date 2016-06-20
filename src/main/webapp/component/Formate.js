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
		if (typeof data !="object") {
			data=new Date(data);
		}
		var time=this.number2(data.getHours())+":"+this.number2(data.getMinutes());
		var date=data.getFullYear()+"年"+this.number2((data.getMonth()+1))+"月"+this.number2(data.getDate())+"日";
		if (new Date().getFullYear()===data.getFullYear()) {//如果是今年就省略年份
			date=this.number2((data.getMonth()+1))+"月"+this.number2(data.getDate())+"日";
		}
	    if (type==='time') {
	        return time;
	    }else if (type=='date'){
	        return date;
	    }else{
	    	return date+" "+time;
	    }
	}
}
